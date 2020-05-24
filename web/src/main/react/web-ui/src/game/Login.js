import React from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

class Login extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            authResponse: 'AUTH RESPONSE',
            username : '',
            password: ''
        };

        this.onSubmit = this.onSubmit.bind(this);
    }

    onSubmit(event) {
        event.preventDefault();
        //const data = new FormData(event.data);

        const {username, password} = this.state;

        const formData = new FormData();
        formData.append('username', username);
        formData.append('password', password);

        axios.post('http://localhost:8080/login', new URLSearchParams(formData))
            .then(response => {
                this.setState({
                    authResponse: JSON.stringify(response.data)
                });
                this.props.history.push("/app");
            }).catch(error => {
                this.setState({
                    authResponse: JSON.stringify(error)
                });
            });

    }

    onChange = (e) => {
        this.setState({[e.target.name]: e.target.value})
    }

    render() {
        return(
            <div>
                <div>{this.state.authResponse}</div>
                <form onSubmit={this.onSubmit}>
                    <input type='text' id='username' name='username' onChange={this.onChange}/>
                    <input type='text' id='password' name='password' onChange={this.onChange}/>

                    <input type='submit' name='submit' value='submit'/>
                </form>
            </div>
        );
    };

}
export default Login;