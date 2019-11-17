const express = require('express');
const app = express();

app.listen(process.env.PORT  || 3000,() =>{
    console.log("server started and is listening on port 3000");
});