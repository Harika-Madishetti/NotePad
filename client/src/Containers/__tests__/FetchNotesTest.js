import React from 'react';
import { create } from 'react-test-renderer';
import FetchNotes from '../FetchNotes';
import axios from 'axios';
import shallow from 'shallow'

jest.mock('axios');

test("Fetch Notes Component", () => {
    it("Get a list of Notes",() => {
        const response = {
            notes: [{id:1,title:"MyNotes-1",content:"Hi, I am testing"},{id:2,title:"MyNotes-2",content:"Hi,Dude"}]
        }
        axios.get.mockResolvedValue(response);
        const component = create(<FetchNotes/>,);
        const instance = component.getInstance();
        instance.componentDidMount();
        console.log("instance")
        console.log(instance.state)
    })
})

test("get", () => {
    it('render',() => {
        const getNotes = jest.spyOn(axios,'get');
        const fetch = shallow(<FetchNotes/>);
        expect(getNotes),toBeCalled();
    })
})

