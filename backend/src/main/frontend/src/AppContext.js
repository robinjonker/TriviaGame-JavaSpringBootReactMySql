import { createContext, useState, useEffect } from "react";

export const AppContext = createContext();

export const AppProvider = ({ children }) => {
  const [questionNumber, setQuestionNumber] = useState([]);
  const [questionId, setQuestionId] = useState([]);
  const [randomQuestion, setRandomQuestion] = useState([]);
  const [possibleAnswers, setPossibleAnswers] = useState([]);
  const [randomAnswer, setRandomAnswer] = useState([]);
  const [answer, setAnswer] = useState("");

  useEffect(() => {
    // line 91 and line 27 the student has been set to 1 as per the assumption, in production this should be another useState
  }, []);

  return (
    <AppContext.Provider
      value={{
        questionNumber,
        setQuestionNumber,
        questionId,
        setQuestionId,
        randomQuestion,
        setRandomQuestion,
        possibleAnswers,
        setPossibleAnswers,
        randomAnswer,
        setRandomAnswer,
        answer,
        setAnswer,
      }}
    >
      {children}
    </AppContext.Provider>
  );
};
