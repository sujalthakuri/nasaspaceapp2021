const express = require('express')
const app = express()
const path = require('path')
const mongoose = require('mongoose')
const bodyParser = require('body-parser')
const cors = require('cors')

const db = require('./database/db')
const customer_route = require('./routes/customer_route')
const gameRoute = require('./routes/gameRoute')
const feedbackRoute = require('./routes/feedbackRoute')
const ratingRoute = require('./routes/ratingRoute')

app.use(express.json())
app.use(cors())

app.use("/pictures",express.static(path.join(__dirname,"pictures")))
app.use(bodyParser.urlencoded({extended:false}))
app.use(customer_route)
app.use(gameRoute)
app.use(feedbackRoute)
app.use(ratingRoute)



app.listen(90)