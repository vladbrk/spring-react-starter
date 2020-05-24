import React from 'react';
import './Common.css';

class Square extends React.Component {
    render() {
        return (
            <button className="btn" onClick={this.props.onClick}>
                {this.props.value}
            </button>
        );
    }


}

export default Square;