import React, { useState } from 'react';

// useState ==> hook
// state management

function Bottle() {
  const [input1, setMyinput1] = useState(0);
  const [input2, setMyinput2] = useState(0);
  const [result, setresult] = useState(0);
  const onChangeinput1 = (e) => {
    setMyinput1(e.target.value);
  };
  const onChangeinput2 = (e) => {
    setMyinput2(e.target.value);
  };
  const onChangeButton=()=>{
      setresult(Number(input1)+Number(input2))
  }

  return (
    <div>
      <input value={input1} onChange={onChangeinput1}></input>
      <input value={input2} onChange={onChangeinput2}></input>
      <button onClick={onChangeButton}>add</button>
      <p>{result}</p>
    </div>
  );
}

export default Bottle;