const multer = require('multer')

// Checks for the file Format
// Allows to store into database if only the format is corrects
const fileFilter = function(req,file,cb){
    if(file.mimetype == 'image/jpeg' || file.mimetype == 'image/png'){
        cb(null,true)
    }
    else{
        cb(null,false)
    }
}

const storage = multer.diskStorage({
    destination : function(req,file,cb){
        cb(null,'./pictures')
    },
    filename : function(req,file,cb){
        cb(null, //Date name is added
            Date.now() + file.originalname)
    }
})

const upload = multer({
    storage : storage,
    //File Format Checker is Called
    fileFilter : fileFilter
})



module.exports = upload