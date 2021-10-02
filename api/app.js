const express = require('express')
const app = express()
const path = require('path')
const mongoose = require('mongoose')
const bodyParser = require('body-parser')
const cors = require('cors')

const db = require('./database/db')
const questionRoute = require('./routes/questionRoute')


app.use(express.json())
app.use(cors())

app.use("/pictures",express.static(path.join(__dirname,"pictures")))
app.use(bodyParser.urlencoded({extended:false}))
app.use(questionRoute)

app.listen(90)