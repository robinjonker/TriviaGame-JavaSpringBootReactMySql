import { useState, useEffect } from "react";
import "./App.css";
import axios from "axios";

// Creating a random question generation hook
const RandomQuestion = () => {
  const [questionNumber, setQuestionNumber] = useState([]);
  const [randomQuestion, setRandomQuestion] = useState([]);
  const [possibleAnswers, setPossibleAnswers] = useState([]);
  const [randomAnswer, setRandomAnswer] = useState([]);

  const fetchRandomQuestion = () => {
    axios
      .get("http://localhost:8080/api/v1/questions_trivia/random/1")
      .then((response) => {
        const first = response.data.split(":", 3);
        const second = first[1].split("? ");
        const third = second[1].split("]");
        setQuestionNumber(first[0]);
        setRandomQuestion(second[0]);
        setPossibleAnswers(third[0]);
        setRandomAnswer(third[1]);
        console.log(questionNumber);
        console.log(randomQuestion);
        console.log(possibleAnswers);
        console.log(randomAnswer);
      });
  };

  useEffect(() => {
    fetchRandomQuestion();
  }, []);

  return (
    <div>
      <h1>{questionNumber}</h1>
      <h1>{randomQuestion + "?"}</h1>
      <h1>{possibleAnswers + "]"}</h1>
      <h1>{randomAnswer}</h1>
    </div>
  );
};

// Creating a custom user input hook
const InputAns = () => {
  const [answer, setAnswer] = useState("");

  return (
    <form>
      <label>
        Enter the answer number:
        <input
          type="text"
          placeholder="e.g. 3"
          value={answer}
          onChange={(e) => setAnswer(e.target.value)}
        />
      </label>
    </form>
  );
};

const LogAnswer = async (student_id, question_id, result) => {
  var today = new Date(),
    date = today.getFullYear() + "-" + (today.getMonth() + 1) + "-";
  const answer_result = getResult();
  const mailToUser = {
    student_id: student_id,
    question_id: question_id,
    answer_result: answer_result,
    date: date,
    result: result,
  };
  await fetch(`http://localhost:8080/api/v1/log`, {
    method: `POST`,
    headers: { "Content-Type": `application/json` },
    body: JSON.stringify(mailToUser),
  });
  console.log(mailToUser);
  return answer_result;
};

// make dynamic
const getResult = () => {
  return false;
};

function App() {
  return (
    <div className="App">
      <RandomQuestion />
      <InputAns />
      <button onClick={() => LogAnswer()}>Press</button>
    </div>
  );
}

export default App;
