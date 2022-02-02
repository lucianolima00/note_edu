import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

export default function Dashboard({ username, notebooks }) {
  const navigate = useNavigate();

  useEffect(() => {
    if (!username) {
      navigate('/login');
    }
    return () => {
      // cleanup
    }
  }, []);
  console.log('notebooks.map()', notebooks.map((notebook)=>({title:notebook.name, description: notebook.notes[0].title})));
  return notebooks.length ?
    <div>
      <CardRow rowTitle={"Notebooks"} cards={notebooks.map((nb) => ({ title: nb.name, description: nb.notes[0].title }))} />
    </div>
    : <p>Nenhum notebook</p>;
}

function CardRow({ rowTitle, cards }) {
  return (
    <div style={container}>
      <div>{rowTitle}</div>
      <div style={rowCard}>
        {cards.map(({ title, description, dueDate }, index) => {
          return index < 3 && (<div style={cardStyle}>
            <h5>{title}</h5>
            <p>{dueDate && <strong>{dueDate}</strong>}</p>
            <p>{description}</p>
          </div>)
        })}
      </div>
    </div>
  )
}

const cardStyle = {
  backgroundColor: "#92CC49",
  display: "flex",
  margin: "35px",
  padding: "50px",
  width: "20%",
  heigth: "20%",
  border: "2px",
}

const container = {
  width: "100%",
  display: "flex",
}

const rowCard = {
  flexFlow: "row nowrap",
  display: "flex",
  justifyContent: "space-between",
  alignItems: "center"
}