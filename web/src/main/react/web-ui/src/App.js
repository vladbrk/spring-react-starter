import React from 'react';
import logo from './logo.svg';
import './App.css';
import Game from './game/Game.js';
import Login from './game/Login.js';
import Contract from './contract/Contract.js';
import Security from './security/Security.js';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';

function App() {
    return (

    <Router>
        <ul className="menu">
            <li><Link to='/app/_login'>Логин</Link></li>
            <li><Link to='/app/contracts'>Контракты</Link></li>
            <li><Link to='/app/security'>Безопасность</Link></li>
            <li><Link to='/app'>Счетчик</Link></li>
        </ul>

        <Switch>
            <Route exact path="/app/_login" component={Login} />
            <Route exact path="/app" component={Game} />
            <Route exact path="/app/contracts" component={Contract} />
            <Route exact path="/app/security" component={Security} />
        </Switch>
    </Router>
    );
}

export default App;
