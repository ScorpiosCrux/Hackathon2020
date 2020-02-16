package main

import (
	colly "github.com/gocolly/colly"
	"os"
	"log"
	"strings"
	"strconv"
	"regexp"
	"fmt"
	"sort"
	"os/exec"
)

type Job struct {
	Name string
	Url string
}

func found(j,u string, jL []Job) (res bool) {
	for _,p := range jL {
		if p.Name == j && p.Url == u {
			return true
		}
	}
	return res
}

func main() {

	languages := map[string]int{
		"react" : 0,
		"vue" : 0,
		"angular" : 0,
		"django" : 0,
		"c/c++" : 0,
		"java" : 0,
		"python" : 0,
		"pearl" : 0,
		"c#" : 0,
		"go" : 0,
		"haskell" : 0,
		"javascript" : 0,
	}

	jobTitle := []string{
		"web+developer",
		"frontend+developer",
		"software+developer",
		"software+engineer",
		"firmware+developer",
	}

	ab := []string{
		"Calgary",
		"Edmonton",
	}

	bc := []string{
		"Vancouver",
		"Burnaby",
		"Richmond",
		"Kelowna",
	}

	nb := []string{
		"Moncton",
	}

	on := []string{
		"Toronto",
		"Ottawa",
		"Mississauga",
		"Brampton",
		"Hamilton",
		"London",
		"Markham",
		"Vaughan",
		"Kitchener",
	}

	qc := []string{
		"Montréal",
		"Québec",
	}

	prov2city := make(map[string][]string)
	prov2city["AB"] = ab
	prov2city["BC"] = bc
	prov2city["NB"] = nb
	prov2city["ON"] = on
	prov2city["QC"] = qc

	c := colly.NewCollector()

	dC := c.Clone()

	jobLinks := make([]Job,0)

	// Find and visit all links
	c.OnHTML("a.jobtitle.turnstileLink[href]", func(e *colly.HTMLElement) {

		jt := strings.TrimSpace(strings.Trim(e.Text,"\n"))
		if len(jt) == 0 {
			return
		}

		url := "https://ca.indeed.com" + strings.TrimSpace(e.Attr("href"))
		
		if !found(jt,url,jobLinks) {
			var j Job
			j.Name = jt
			j.Url = url
			jobLinks = append(jobLinks,j)
		}
	})

	dC.OnHTML(`div[id=jobDescriptionText]`, func(e *colly.HTMLElement) {
		str := strings.ToUpper(strings.Replace(e.Text,"\n","",-1))
		
		for l,_ := range languages {
			match, _ := regexp.MatchString("\\b(\\s*"+strings.ToUpper(l)+"\\s*)\\b", str)
			if match {
				languages[l]++
			}
		}
	})

	sti := len(jobLinks)
	pageNum := 0
	pSN := "00"
	var ul string
	var done bool
	for _,position := range jobTitle{
		for prov, cities := range prov2city {
			for _,city := range cities {
				for !done && pageNum < 210 {
					
					if pageNum > 0 {
						pSN = strconv.Itoa(pageNum)
					}
					
					ul = "https://ca.indeed.com/jobs?q="+position+"&l="+city+"%2C+"+prov+"&start="+ pSN
			
					c.Visit(ul)
					if len(jobLinks) == sti {
						done = true
						break
					}
			
					pageNum += 10
					sti = len(jobLinks)
				}

				for _,collectedJob := range jobLinks {
					dC.Visit(collectedJob.Url)
				}
			}
		}
	}

	fname := genNewName()
	file, err := os.Create("../DB/data/" + fname)
	defer file.Close()
	if err != nil {
		log.Fatal(err)
	}

	for l,n := range languages {
		writeFile( fmt.Sprintf("%s: %d jobs\n",l,n) , file )
	}

	cmd := exec.Command("./compute")
    if err := cmd.Run(); err != nil {
        log.Fatal(err)
    }
}


func genNewName() string {
	d, err := os.Open("../DB/data")
	
	if err != nil {
        log.Fatal(err)
    }
	
	defer d.Close()
	
	contents, err := d.Readdirnames(-1)
	
	if err != nil {
        log.Fatal(err)
	}

	if len(contents) > 0 {

		var temp []int
		for _,f := range contents {
			
			i := strings.Split(f,".")[0]
			n,err := strconv.Atoi(i)
			if err != nil  {
				log.Fatal(err)
			}
			temp = append( temp , n )
		}
		sort.Ints(temp)
		return strconv.Itoa(temp[len(temp)-1]+1)+".txt"
	}

	return "1.txt"
}

func writeFile(content string, file *os.File) error {
	_,err := file.WriteString(content)
	if err != nil {
		return err
	}	
	return nil
}