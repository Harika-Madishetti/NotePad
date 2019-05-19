import React from 'react';
import { shallow, mount } from 'enzyme';
import Header from '../Header';

describe("component", () => {
    const Wrapper = shallow(<Header/>)
    const component = mount(<Header/>)
    it("should render Header Component", () => {
        expect(component.getElements()).toMatchSnapshot();
    });

    it("should check exitance of tag header", () => {
        expect(component.find('header')).toExist();
    })

    it("should check exitance of tag h1", () => {
        expect(component.find('h1')).toExist();
    })

    it("should check the text in tag h1", () => {
        expect(component.find('h1')).toHaveText('NotePad')
    })
})
