const apiUrl = "http://localhost:5000/users"

async function listUsers(){
    const response = await fetch(apiUrl)
    const users = await response.json()
    const usersList = document
	.getElementById('users-list')

    usersList.innerHTML = ''
    users.foreach( user => {
	const userDiv = document
	    .createElement('div')

	userDiv.innerHTML = `
	    <p>ID: ${user.id}  </p>
	    <p>Name: ${user.name}</p>
	    <p>Email: ${user.email}</p>
	`
	usersList.appendChild(userDiv)
    })
}

document.getElementById("user-form").onsubmit = async (e) => {

    e.preventDefault()

    const id = document.getElementById("user-id")
	.value
    
    const name = document.getElementById("name")
	.value

    const email = document.getElementById("email")
	.value

    const userData = {name, email}

    if(id){
	await fetch(`${apiUrl}/${id}`, {
	    method: "PUT",
	    headers: {
		'Content-Type': 'application/json'
	    },
	    body: JSON.stringify(userData)
	})
    }
    else{
	await fetch(apiUrl, {
	    method: 'POST', 
	    headers: {
		'Content-Type': 'application/json'
	    },
	    body: JSON.stringify(userData)
	})
    }
    listUsers()
}

window.onload = () => {
    console.log("HHHH")
    listUsers();
}
