import React from 'react';
import Modal from 'react-bootstrap/Modal'
import {Button} from 'react-bootstrap';
import Header from "./Header/Header";

class NotePadModel extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            show:false,
        }
    }

    handleHide = () => {
        this.setState({
            show:false
            })
    }
    handleShow = () => {
        this.setState({
            show:true
        })
   }

    render(){
        return(<>
            <header className="AppContainer">
                <Header/>
            </header>
            <input placeholder="Take a note" className="new-notes" onClick={this.handleShow}>
            </input>
            <Modal show={this.state.show}
                    onHide={this.handleHide}>
                <Modal.Header closeButton>
                    <Modal.Title id="example-custom-modal-styling-title" >
                        Title
                    </Modal.Title>
                </Modal.Header>
                <Modal.Body>Take a note...</Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={this.handleHide}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal>
                </>
        )
    }
}
export default NotePadModel;