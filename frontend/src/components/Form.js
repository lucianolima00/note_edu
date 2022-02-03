import React from 'react';

export default function Form(props) {
  return <div style={container}>
        <h2>{props.title}</h2>
        <form onSubmit={props.onSubmit}>
            {props.children}
        </form>
      </div>
}

const container = {
    width: '100%',
    maxWidth: '720px',
    margin: '32px',
    padding: '32px',
    marginLeft: 'auto',
    marginRight: 'auto',
    border: '4px solid #666',
    borderRadius: '24px',
    textAlign: 'center',
}