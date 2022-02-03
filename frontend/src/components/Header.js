import React from 'react'
import { Link, useLocation } from 'react-router-dom'

export default function Header({username}) {
    const loc = useLocation();
    // console.log(loc)
    return (
        <div style={container}>
            <div style={header}>
                <div style={logo}>N</div>
                <div style={logo}>NOTE.EDU</div>
                <div>
                    {username != ""?
                    <p>{username? ("Hello " + username) : <Link to={"/login"}>Sign In</Link>}</p>
                    : null}
                </div>
            </div>
        </div>
    )
}

const container = {
    width: '100%',
    display: 'flex',
    minHeight: '70px',
    boxShadow: '0 3px 3px #4444',
    flexFlow: 'column nowrap',
    justifyContent: 'center',
    backgroundColor: '#f5f242'
}

const header = {
    display: 'flex',
    flexFlow: 'row nowrap',
    maxWidth: '1080px',
    width: '100%',
    marginLeft: 'auto',
    marginRight: 'auto',
    justifyContent: 'space-between',
    alignItems: 'center'
}

const logo = {
    fontFamily: 'Porter Sans Block',
    fontSize: '40px'
}

