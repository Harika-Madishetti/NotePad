import React from 'react';
import Header from './Header'
import renderer from 'react-test-renderer'
import { shallow } from 'enzyme';

describe('Renders header title component',() =>{
    it('It should render the Title',() => {
        const component = shallow(<Header><h1 id="unique"/></Header>)
        expect(component.contains(<h1 id="unique"/>)).to.equal(true)
    })
})
