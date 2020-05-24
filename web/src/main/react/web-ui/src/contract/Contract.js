import React from 'react';
import axios from 'axios';

class Contract extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            contracts: []
        }
    }

    componentDidMount() {
        axios.get('http://localhost:8080/api/contracts')
        .then(response => {
            this.setState({
                contracts: response.data
            });
        }).catch(error => {
            console.log(error);
        });

    }

    renderContracts() {
        const contractsHtml = this.state.contracts.map( contract =>
            <tr key={contract.id}>
                <td>{contract.title}</td>
                <td>{contract.startDate}</td>
                <td>{contract.closureDate}</td>
                <td>{contract.cost}</td>
            </tr>
        );
        return (
            <table>
                <thead>
                    <tr>
                        <th>Наименование</th>
                        <th>Дата начала</th>
                        <th>Дата окончания</th>
                        <th>Стоимость</th>
                    </tr>
                </thead>
                <tbody>
                    {contractsHtml}
                </tbody>
            </table>
        );
    }

    render () {
        return (
            <div>
                <h1>Контракты</h1>
                {this.renderContracts()}
            </div>
        )
    }
}

export default Contract;