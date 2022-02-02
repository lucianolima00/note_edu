import React from 'react'

export default function UIState(props) {
    return props.loading? (
        <div style={{
            position: 'absolute',
            width: '100vw', 
            height: '100vh', 
            display: 'flex', 
            justifyContent: 'center',
            alignItems: 'center', 
            zIndex: 999,
            backgroundColor: '#444d'}}>
            <div>Carregando...</div>
        </div>
    ) : null;
}
