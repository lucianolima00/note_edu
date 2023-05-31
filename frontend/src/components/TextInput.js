import React from 'react';

export default function TextInput({label, name, placeholder = "", type, setInputValue = ()=>{}, style={}}) {

  return <div style={{...container, ...style}}>
      <label style={labelStyle}>{label}:</label>
      {type === "textarea"
      ? <textarea name={name} style={inputStyle} onChange={e => setInputValue(e.target.value)}></textarea> 
      : <input name={name} style={inputStyle} placeholder={placeholder} type={type} onChange={e => setInputValue(e.target.value)}/>
    }
  </div>;
}

const container = {
    display: 'flex',
    flexFlow: 'column nowrap',
    justifyContent: 'flex-start',
    alignItems: 'flex-start',
    marginTop: '12px'
}
const labelStyle = {
    fontWeight: 'bold',
    fontSize: '16px',
    marginBottom: '8px'
}
const inputStyle = {
    width: '100%',
    padding: '12px',
    borderRadius: '8px',
    border: '3px solid #666'
}