const fs = require("fs")
fs.readdir("./",(err,files)=>{
if (err) throw err
else {
console.log(files.length)
}
}
)
