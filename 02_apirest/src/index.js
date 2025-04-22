const express = require("express")
const cors = require("cors");
const path = require('path');
const user = require("./control/usercontroller")

const app = express()
app.use(express.json())

app.use(cors());

const port = 5000

// Creando los endpoints para la gestion de usuarios:
app.get("/users", user.list)

app.get("/users/:id", user.get)

app.post("/users/", user.create)

app.put("/users/:id", user.update)

app.delete("/users/:id", user.delete)


// método | verbo GET
app.get("/", (req, res) => {
  // 200 -> OK : https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/200
  res.status(200).send("Hola desde el API")  
})

app.post("/", (req, res) => {
   // 201 -> OK -> Data Created : https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/201
  res.status(201).send("element created")  
})

app.put("/", (req, res) => {
  res.status(204).send("NO Content in edit")  
})

app.delete("/", (req, res) => {
  res.status(204).send("NO content in delete")  
})

app.get('*', (req, res) => {
    res.status(404).sendFile(path.join(__dirname, '..', 'public' , 'notfound.html'))
})

app.listen(port)
