package main

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func main(){
	router := gin.Default()

	router.GET("/", func (c *gin.Context)  {
		c.JSON(http.StatusOK, gin.H{
			"name": "Agung Septiawa",
			"bio": "A Software Engineer",

		})
	})

	router := gin.Default()

	router.GET("/hello", func (c *gin.Context)  {
		c.JSON(http.StatusOK, gin.H{
			"name": "Agung Septiawa",
			"bio": "A Software Engineer",

		})
	})

	router.Run()
}