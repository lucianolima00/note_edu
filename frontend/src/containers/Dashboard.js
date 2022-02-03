import React from 'react';
import { Link } from 'react-router-dom';
import CardRow from '../components/CardRow';

export default function Dashboard({ username, notebooks, reminders, postits }) {

  return <div style={container}>
    {
      /* notebooks.length ?
        <div>
          <CardRow
            rowTitle={"Notebooks"} 
            addButtonLocation={"/addNotebook"}
            cards={notebooks.map(
                notebook => ({ 
                  title: notebook.name, 
                  description: ""
                })
              )} 
            />
        </div>
        : <>
        <p>Nenhum notebook.</p><br/>
        <Link to="/reminder/add">Criar</Link>
        </> */
    }
    {
      reminders.length ?
        <div>
          <CardRow
            rowTitle={"Reminders"}
            addButtonLocation={'/reminder/add'}
            cards={reminders.map(
              reminder => ({
                id: reminder.id,
                title: reminder.title,
                description: reminder.description,
                dueDate: reminder.dueDate
              }))}
          />
        </div>
        : <>
        <p>Nenhum reminder</p><br/>
        <Link to="/reminder/add">Criar</Link>
        </>
    }
    {
      postits.length ?
        <div>
          <CardRow
            rowTitle={"Post-Its"}
            addButtonLocation={'/postit/add'}
            cards={postits.map(
              postit => ({
                id: postit.id,
                title: postit.title,
                description: postit.description,
                dueDate: postit.dueDate
              }))}
          />
        </div>
        : <>
        <p>Nenhum postit</p><br/>
        <Link to="/postit/add">Criar</Link>
        </>

    }
  </div>
}

const container = {
  maxWidth: '1080px',
  margin: 'auto'
}