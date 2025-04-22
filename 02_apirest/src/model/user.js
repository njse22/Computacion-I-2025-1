class User {
    constructor(name, email){
	console.log("USER")
	console.log(name)
	console.log(!name)

	console.log(email)
	console.log(!email)

	if(!name || !email){
	    throw new Error("Name and Email can not be empty")
	}

	this.name = name;
	this.email = email;
    }
}

module.exports = User;
