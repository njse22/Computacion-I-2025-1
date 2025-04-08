
let variable

function showMessage(){
    // == 
    // === | exactamente igual
    console.log('1' == 1) // true
    console.log('1' === 1) // false
    console.log('5' + 1) // 51
    console.log(variable) // undefined

    console.log(null > 0)  // false
    console.log(null === 0) // false
    console.log(null >= 0) // true

    console.log("" != " ")
    console.log("" !== "")

}

function addTextToList(){
    const list = document.getElementById("formElement")
    const text = document.getElementById("inputText")

    if(text.value.trim() != ""){
	const item = document.createElement("li")
	item.textContent = text.value
	list.appendChild(item)
	text.value = ""
    }
}



window.onload = () => {


    const listElements = document.getElementById("listElements")
    const elements = document.querySelectorAll("#formElement li")

    elements.forEach( (element, index) => {

	console.log(`elemento ${index}:`, element)
	element.textContent = `Nuevo elemento desde onload ${index}`

    })
    


    msgText = document.getElementById("msgText")

    msgText.addEventListener("click", () => {
	msgText.style.color = "#00dfff"
    })
    

}
