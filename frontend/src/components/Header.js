import React from 'react'
import { Link, useLocation } from 'react-router-dom'

export default function Header({username}) {
    const loc = useLocation();
    // console.log(loc)
    return (
        <div style={container}>
            <div style={header}>
                <div>Logo</div>
                <div>NOTE.EDU</div>
                <div>
                    {!loc.pathname.includes("login")?
                    <p>{username || <Link to={"/login"}>Sign In</Link>}</p>
                    : null}
                </div>
            </div>
        </div>
    )
}

const container = {
    width: '100%',
    display: 'flex',
    minHeight: '100px',
    flexFlow: 'column nowrap',
    justifyContent: 'center',
    backgroundColor: '#f5f242'
}

const header = {
    display: 'flex',
    flexFlow: 'row nowrap',
    maxWidth: '1080',
    justifyContent: 'space-between'
}

