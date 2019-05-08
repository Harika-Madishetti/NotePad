import React, {Component} from 'react';
import axios from 'axios';
import Header from "./Header/Header"

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            Notes: [],
        };
    }

    componentDidMount() {
        axios.get('/notes').then((response) => {
            console.log(response)
            this.setState({
                Notes:response.data
            })
        })
    }
    render() {
        console.log("in render of new app")
        return (<div>
            <header className="AppContainer">
                <Header/>
                <form>
                    <input className="new-notes"
                        placeholder="Take a Note...">
                    </input>
                </form>
            </header>
            </div>
        );
    }
}

export default App;
