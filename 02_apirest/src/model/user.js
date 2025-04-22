class User {
    constructor(name, email){
	if(!name || !email){
	    throw new Error("Name and Email can not be empty")
	}

	this.name = name;
	this.email = email;
    }
}

module.exports = User;
