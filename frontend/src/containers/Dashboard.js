import React, { useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import CardRow from '../components/CardRow';

export default function Dashboard({ username, notebooks, reminders, postits }) {
  const navigate = useNavigate();

  useEffect(() => {
    if (!username) {
      navigate('/login');
    }
    return () => {
      // cleanup
    }
  }, []);
  return <div>
    {
      notebooks.length ?
        <div>
          <CardRow
            rowTitle={"Notebooks"} 
            addButtonLocation={"/addNotebook"}
            cards={notebooks.map(
                notebook => ({ 
                  title: notebook.name, 
                  description: notebook.notes[0].description 
                })
              )} 
            />
        </div>
        : <p>Nenhum notebook</p>
    }
    {
      reminders.length ?
        <div>
          <CardRow
            rowTitle={"Reminders"}
            addButtonLocation={'/addRemider'}
            cards={reminders.map(
              reminder => ({
                id: reminder.id,
                title: reminder.title,
                description: reminder.description,
                dueDate: reminder.reminder[0].dueDate
              }))}
          />
        </div>
        : <p>Nenhum reminder</p>
    }
    {
      Postits.length ?
        <div>
          <CardRow
            rowTitle={"Postits"}
            addButtonLocation={'/addPostit'}
            cards={postits.map(
              postit => ({
                id: postit.id,
                title: postit.title,
                description: postit.description,
                dueDate: postit.postit[0].dueDate
              }))}
          />
        </div>
        : <p>Nenhum postit</p>
    }
  </div>
}