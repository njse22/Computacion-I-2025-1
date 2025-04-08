const express = require("express")
const app = express()

app.use(express.json())

const port = 5000


// método GET -> al recurso /
app.get("/", (req, res) => {
    res.status(200).send("Hola API")
})

app.listen(port)
