# POC-SpringBoot
RESTful API using Spring Boot. This is a POC for the java-spring session attended at Gemini.\
<h4>Database configuration</h4>
<ol>
<li> Create a database named <em>springJdbc</em> in MySQL</li>
<li> Create a table named <em>user</em></li>
<li>
<pre>------+---------------------
| Field | Type             |
+-------+------------------+
| id    | int(10) unsigned |
| name  | varchar(10)      |
| email | varchar(30)      |
------+---------------------</pre>
</li>
<li>
Change the MySQL configuration in src/main/resources/application.properties:
<ul>
<li> spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/springJdbc</li>
<li> spring.datasource.username=USERNAME_HERE</li>
<li> spring.datasource.password=PASSWORD_HERE<br> </li>
</ul>
</li>
</ol>
<h4>APIs</h4>
<ul>
<li>GET <em>localhost:8080/api/student</em> </li>
<li>GET <em>localhost:8080/api/student?roll=3</em></li>
<li>POST <em>locallocalhost:8080/api/student</em> <br>
<pre>JSON
{
	"roll":4,
	"phone":"9090909090",
	"name":"batman"
}
</pre>
</li>
<li>PUT <em>locallocalhost:8080/api/student/{roll}</em> <br>
<pre>JSON
{
	"name":"bruce wayne"
}
</pre>
<li>DELETE <em>localhost:8080/api/student?roll=4 </em> </li>
</ul>
