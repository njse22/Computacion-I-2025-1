const path = require("path")
const fs = require("fs")

const dbPath = path.join(__dirname, "../..", 'data', 'database.json')

const DBConnection = {
    readDB: () => {
	    const data = fs.readFileSync(dbPath, 'utf-8')
	    return JSON.parse(data)
    }, 

    writDB: (data) => {
    	fs.writeFileSync(dbPath, JSON.stringify(data, null, 2))
    }
}

module.exports = DBConnection
