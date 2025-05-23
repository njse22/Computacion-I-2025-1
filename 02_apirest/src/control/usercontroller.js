const dbConnection = require("../connection/database")
const user = require("../model/user")

const UserController = {
    // GET -> Listar
    list: (req, res) => {
	const db = dbConnection.readDB()
        res.status(200).json(db.users)
    }, 
    get: (req, res) => {
	try{
	    const db = dbConnection.readDB(); 
	    console.log(req.params)
	    console.log(req.body)
	    const id = req.params.id;
	    const userGet = db.users.find(user => user.id == id)
	    console.log("Controller::userGet >> ", userGet)
	    if(!userGet){
		res.status(404).json({error: "user not found"})
	    }
	    else{
		res.status(200).send( userGet )
	    }
	}
	catch(error){
	    res.status(500).json({error: error.message})
	}

    },
    // POST 
    create: (req, res) => {

	try {
	    const db = dbConnection.readDB()
	    const userData = req.body
	    console.log(req.body.name)
	    console.log(req.body.email)

	    const newUser = new user(userData.name, userData.email)
	    
	    newUser.id = db.users.length ? db.users[db.users.length - 1].id + 1 : 1;

	    db.users.push(newUser)
	    dbConnection.writDB(db)

	    res.status(201).send("create user ")
	}
	catch(error){
	    res.status(500).json({error: error.message })
	}
    },
    // PUT 
    update: (req, res) => {
	try{
	    const db = dbConnection.readDB();
	    const userData = req.body
	    const id = parseInt(req.params.id);
	    const userIndex = db.users.findIndex(user => user.id === id)

	    if(userIndex === -1){
		res.status(404).json({error: "User Not Found"})
	    }

	    else{
		db.users[userIndex] = { id, ...userData };
		dbConnection.writDB(db)
		res.status(204).send()
	    }
	}
	catch(error){
	    res.status(500).json({error: error.message})
	}
    }, 
    delete: (req, res) => {

	try{
	    const db = dbConnection.readDB(); 
	    const id = req.params.id;
	    const userIndex = db.users.findIndex(user => user.id == id)

	    if(userIndex === -1){
		res.status(404).json({error: "User Not Found"})
	    }
	    else{
		db.users.splice(userIndex, 1); 
		dbConnection.writDB(db)
		res.status(204).send()
	    }
	}
	catch(error){
	    res.status(500).json({error: error.message})
	}
    }
}

module.exports = UserController;
