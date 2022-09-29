import { useState, useEffect, useContext } from "react";
import "./App.css";
import axios from "axios";
import { AppContext } from "./AppContext";

// Creating a random question generation hook
const RandomQuestion = () => {
  // const [questionNumber, setQuestionNumber] = useState([]);
  // const [randomQuestion, setRandomQuestion] = useState([]);
  // const [possibleAnswers, setPossibleAnswers] = useState([]);
  // const [randomAnswer, setRandomAnswer] = useState([]);

  const {
    questionNumber,
    setQuestionNumber,
    setQuestionId,
    randomQuestion,
    setRandomQuestion,
    possibleAnswers,
    setPossibleAnswers,
    randomAnswer,
    setRandomAnswer,
  } = useContext(AppContext);

  const fetchRandomQuestion = () => {
    axios
      .get(`http://localhost:8080/api/v1/questions_trivia/random/1`)
      .then((response) => {
        console.log(response.date);
        const first = response.data.split(":", 3);
        const second = first[1].split("? ");
        const third = second[1].split("]");
        const forth = first[0].split("");
        const fifth = third[1].split("");
        setQuestionId(forth[1]);
        setQuestionNumber(first[0]);
        setRandomQuestion(second[0]);
        setPossibleAnswers(third[0]);
        setRandomAnswer(fifth[1]);
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
  const { answer, setAnswer } = useContext(AppContext);
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

const LogAnswer = () => {
  const { questionId, randomAnswer, answer } = useContext(AppContext);
  const [state, setState] = useState("");
  setState(false);
  const postLogAnswer = async () => {
    var today = new Date(),
      date =
        today.getFullYear() +
        "-" +
        (today.getMonth() + 1) +
        "-" +
        today.getDate();
    const answer_result = getResult(randomAnswer, answer);
    const logRequest = {
      student_id: "1",
      question_id: questionId,
      answer_result: answer_result,
      date: date,
      result: answer,
    };
    await axios
      .post("http://localhost:8080/api/v1/log", logRequest)
      .then((res) => console.log(res))
      .catch((err) => console.log(err));
    if (answer_result === "true") {
      return <div>Correct!</div>;
    } else {
      return <div>Incorrect!</div>;
    }
  };

  return (
    <div>
      <button onClick={() => postLogAnswer()}>Press to log answer</button>
    </div>
  );
};

// make dynamic
const getResult = (randomAnswer, answer) => {
  if (randomAnswer === answer) {
    return "true";
  }
  return "false";
};

function App() {
  return (
    <div className="App">
      Welcome to the Trivia Game!
      <RandomQuestion />
      <InputAns />
      <LogAnswer />
    </div>
  );
}

export default App;
