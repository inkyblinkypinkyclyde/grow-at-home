const assert = require('assert')
const DateStuff = require('../DateStuff.js');

describe('DateStuff', function () {
    let dateStuff

    beforeEach(function () {
        dateStuff = new DateStuff(new Date('2022-08-21'), new Date('2022-08-20'))
    })

    it('Should return testString', function () {
        const expected = 'Hello'
        assert.strictEqual(dateStuff.returnTestString('Hello'), expected)
    })

    it('should return milliseconds between date1 and date 2', function () {
        const expected = 86400000
        assert.strictEqual(dateStuff.milliSecondsBetween(), expected)
    })

    it('should return an integer base on the "unit string passed in', function () {
        const expected = 24
        assert.strictEqual(dateStuff.unitReturn("hours"), expected)
    })
})