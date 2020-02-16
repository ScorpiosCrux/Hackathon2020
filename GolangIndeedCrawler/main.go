package main

import (
	colly "github.com/gocolly/colly"
	"fmt"
	"strings"
	"strconv"
	"regexp"
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

	wordSearch := "REACT"
	jobTitle := "web+developer"
	count := 0

	c := colly.NewCollector(
		colly.CacheDir("./indeed_cache"),
	)

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
		match, _ := regexp.MatchString("\\b(\\s*"+wordSearch+"\\s*)\\b", str)
		if match {
			count++
		}
	})
	
	// jobTitle := "web+developer"
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

	// link := "https://ca.indeed.com/jobs?q="+jobTitle+"&l="+city+"%2C+"+prov
	
	// sti := len(jobLinks)
	// pageNum := 0
	// pSN := "00"
	// var ul string
	// var done bool
	// for !done && pageNum < 210 {
		
	// 	if pageNum > 0 {
	// 		pSN = strconv.Itoa(pageNum)
	// 	}

	// 	ul = "https://ca.indeed.com/jobs?q=web+developer&l=Calgary%2C+AB&start="+ pSN

	// 	c.Visit(ul)
	// 	if len(jobLinks) == sti {
	// 		done = true
	// 		break
	// 	}

	// 	pageNum += 10
	// 	sti = len(jobLinks)
	// }

	sti := len(jobLinks)
	pageNum := 0
	pSN := "00"
	var ul string
	var done bool
	for prov, cities := range prov2city {
		for _,city := range cities {
			for !done && pageNum < 2  10 {
				
				if pageNum > 0 {
					pSN = strconv.Itoa(pageNum)
				}
		
				ul = "https://ca.indeed.com/jobs?q="+jobTitle+"&l="+city+"%2C+"+prov+"&start="+ pSN
		
				c.Visit(ul)
				if len(jobLinks) == sti {
					done = true
					break
				}
		
				pageNum += 10
				sti = len(jobLinks)
			}
		}

		for _,collectedJob := range jobLinks {
			dC.Visit(collectedJob.Url)
		}
	}
	fmt.Println(count)
}
