import React from 'react';
import axios from 'axios';

import Square from './Square.js';
import './Common.css';

class Board extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            squares: Array(3).fill(0),
            squaresHistory: [],
            test: 'Test',
            message: 'Contractors'
        }

        this.saveSquares = this.saveSquares.bind(this);


    }


    /*var config = {
        headers: {'Access-Control-Allow-Origin': '*'}
    };*/






    renderSquares() {
        let squares = [];
        for(let i=0; i < this.state.squares.length; i++) {
            squares.push(<Square key={i} value={this.state.squares[i]} onClick={() => this.handleClick(i)}/>);
        }
        return squares;
    }

    handleClick(i) {

        this.setState((prevState, props) => {
            let squares = prevState.squares.slice();
            squares[i] = squares[i] + 1;
            return {squares: squares, squaresHistory: prevState.squaresHistory};
        });

    }

    saveSquares() {
        this.setState((prevState, props) => {
            let squares = prevState.squares.slice();
            prevState.squaresHistory.push(squares);
            let squaresHistory = prevState.squaresHistory;
            return {
                squaresHistory: squaresHistory
            };
            /*return {
                squares: prevState.squares,
                squaresHistory: prevState.squaresHistory
            };*/
        });
    }

    renderHistory() {
        let history = [];
        for (let i=0; i < this.state.squaresHistory.length; i++) {
            history.push(<div key={i}>{ this.state.squaresHistory[i].toString() }</div>)
        }
        return history;
    }

    render() {
        return (
            <div>
                {this.renderSquares()}
                <button className='btn' onClick={this.saveSquares}>Save</button>
                <div>{this.renderHistory()}</div>
            </div>
        )
    }
}

export default Board;