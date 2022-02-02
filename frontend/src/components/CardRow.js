import React from 'react'
import { Link } from 'react-router-dom'

export default function CardRow({ rowTitle, cards, addButtonLocation }) {
    return (
      <div style={container}>
        <div>{rowTitle}</div>
        <div style={rowCard}>
          {cards.map(({ id, title, description, dueDate }, index) => {
            return index < 3 && (<div key={id} style={cardStyle}>
              <h4 style={cardTitle}>{title}</h4>
              <h5 style={cardSubtitle}>{dueDate && <strong>{dueDate}</strong>}</h5>
              <div style={cardDescription}>{description}</div>
            </div>)
          })}
          <Link style={linkAdd}to={addButtonLocation}>+</Link>
          {/* <button>+</button> */}
        </div>
      </div>
    )
  }
  
  
  const cardDescription = {
    margin: '8px',
    marginTop: 0,
    marginBottom: '12px',
    height: '40px',
    overflow: 'hidden',
    fontSize: '16px',
    textOverflow: 'ellipsis'
  }
  
  const cardSubtitle = {
    margin: '8px',
    marginTop: 0,
    height: '18px'
  }
  
  const cardTitle = {
    textAlign: 'center',
    margin: '8px'
  }
  
  const cardStyle = {
    backgroundColor: "#92CC49",
    display: "flex",
    flexFlow: 'column nowrap',
    padding: '14px',
    width: '200px',
    margin: "20px",
    // padding: "20%",
    // width: "20%",
    // heigth: "20%",
    border: "2px",
    alignContent: "center",
    borderRadius: '20px'
  }
  
  const container = {
    width: "100%",
    maxWidth: "1080px",
    marginTop: '32px',
    marginLeft: 'auto',
    marginRight: 'auto',
    display: "flex",
    flexFlow: 'column nowrap',
  }
  
  const rowCard = {
    flexFlow: "row nowrap",
    display: "flex",
    // justifyContent: "space-between",
    justifyContent: 'flex-start',
    alignItems: "center",
    width: '100%'
  }
  
  const linkAdd = {
    display: 'flex',
    width: '50px',
    height: '50px',
    textAlign: 'center',
    justifyContent: 'center',
    fontSize: '24px',
    alignItems: 'center',
    textDecoration: 'none',
    borderRadius: '30px',
    border: '4px solid #555',
    color: '#555',
    fontWeight: 'bold'
  }
