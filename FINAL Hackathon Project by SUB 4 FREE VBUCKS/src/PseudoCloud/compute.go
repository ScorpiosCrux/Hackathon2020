package main

import(
	"os"
	"log"
	"fmt"
	"io"
	"strings"
	"strconv"
	"regexp"
)

func main() {
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

		resultStat := map[string][]int{
			"react" : []int{0,0},
			"vue" : []int{0,0},
			"angular" : []int{0,0},
			"django" : []int{0,0},
			"c/c++" : []int{0,0},
			"java" : []int{0,0},
			"python" : []int{0,0},
			"pearl" : []int{0,0},
			"c#" : []int{0,0},
			"go" : []int{0,0},
			"haskell" : []int{0,0},
			"javascript" : []int{0,0},
		}

		for _,f := range contents {
	
			str := strings.Trim(readFile("../DB/data/"+f), "\n")
			str = strings.Trim(strings.TrimSpace(str),"\n")
	
			m := strings.Split(str,"\n")
			for _,v := range m {
				r := strings.Split(v,":")				
				if regexp.MustCompile(`^[a-zA-Z0-9]|c#+$`).MatchString(r[0]) {
					l := strings.TrimSpace(r[0])
					nJ := strings.TrimSpace(r[1])
					n,_ := strconv.Atoi(strings.Split(nJ," ")[0])
					resultStat[l][0]+=n
				}
			}	

			for _,a := range resultStat {
				a[1] = a[0]/len(contents)
			}
		}

		file, err := os.Create("../DB/computing/stat.txt")
		defer file.Close()
		if err != nil {
			log.Fatal(err)
		}

		for l,n := range resultStat {
			t := fmt.Sprintf("%s : Total- %d jobs|Mean- %d jobs\n",l,n[0],n[1])
			writeFile( t, file )
		}
	}
}

func readFile(p string) string {
 
    file, err := os.OpenFile(p, os.O_RDWR, 0644)
    if err != nil {
        log.Fatal(err)
    }
    defer file.Close()

    var text = make([]byte, 1024)
    for {
        _, err = file.Read(text)

       
        if err == io.EOF {
            break
        }

        if err != nil {
            break
        }
    }

    return string(text)
}

func writeFile(content string, file *os.File) error {
	_,err := file.WriteString(content)
	if err != nil {
		return err
	}	
	return nil
}