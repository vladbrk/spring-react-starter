import React from 'react';
import axios from 'axios';

class Security extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            users: []
        }
    }

    componentDidMount() {
        axios.get('http://localhost:8080/api/users')
        .then(response => {
            this.setState({
                users: response.data
            });
        }).catch(error => {
        console.log(error);
        });
    }

    concatRoles(user) {
        let roles = user.roles.map(r => r.role.value);
        let str = '';
        roles.forEach(r => str = str + r + ', ');
        return str;
    }

    renderUsers() {

        const body = this.state.users.map( user =>
            <tr>
                <td>{ user.username }</td>
                <td>{ this.concatRoles(user) }</td>
            </tr>
        );

        return (
            <table>
                <thead>
                    <tr>
                        <th>Логин</th>
                        <th>Права</th>
                    </tr>
                </thead>
                <tbody>
                    { body }
                </tbody>
            </table>
        )
    }

    render () {
        return (
            <div>
                <h1>Безопасность</h1>
                { this.renderUsers() }
            </div>
        )
    }
}

export default Security;