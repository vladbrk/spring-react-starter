import React from 'react';
import Board from './Board.js';
import axios from 'axios';
import { Link } from 'react-router-dom';

class Game extends React.Component {

    render() {
        return(
            <div>
                <Board/>
            </div>
        );
    };
}

export default Game;



