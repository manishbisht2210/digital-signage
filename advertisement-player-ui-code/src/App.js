import React, {Component} from 'react';
import './App.css';
import {Screen} from "./Screen";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            content: {}
        }
    }

    componentDidMount() {
        let eventSource = new EventSource('http://localhost:8080/stream-flux');
        eventSource.onmessage = function (e) {
            this.setState({
                content: JSON.parse(e.data)
            });
        }.bind(this);
    }

    render() {
        return (
            <div className="App">
                <Screen data={this.state.content}/>
            </div>
        );
    }
}

export default App;