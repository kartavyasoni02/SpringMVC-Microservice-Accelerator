function go(url)
{
	window.location = url;
}

function newSurvey()
{
	window.location = "saveSurvey.do";
}
function newQuestion()
{
	window.location = "saveQuestion.do";
}

function deleteContact(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}

function addQuestion() {
    //Create an input type dynamically.
    var element = document.createElement("input");
    //Assign different attributes to the element.
    element.setAttribute("id", "classe");
    element.setAttribute("type", "text");
    document.body.appendChild(element);
}


