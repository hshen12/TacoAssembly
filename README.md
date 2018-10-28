# TacoAssembly

Author: Hao Shen
Code exercise link: https://www.clicktime.com/ctc/devintern.html 

The project is to build a web application base on jetty and java servlet. The website used check box to gether user choices. 
Basedon the choices, it will store user choices. 

## Prerequisites
The local machine need to have java 8 or later version installed. 

## Usage
Compile: javac *.java

Run: java Driver -port int -threads int

-port is an optional flag. The next value int indicate the port your want it to run on. If not provided, the default 
port is localhost:8080

-threads is am optional flag. The next value int indicate how many worker queue you want to use to crawl the web api.
The default value is 5. 
