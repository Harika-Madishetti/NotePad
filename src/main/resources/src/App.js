import React, { Component } from 'react';
import axios from 'axios';
import {Table,Button} from 'reactstrap'

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
        return (
            <div className="App container">
                <Table>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Content</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>title</td>
                        <td>
                            <Button colour="success" size="sm">Save</Button>
                        </td>
                    </tr>
                    </tbody>
                </Table>
            </div>
        );
    }
}

export default App;
