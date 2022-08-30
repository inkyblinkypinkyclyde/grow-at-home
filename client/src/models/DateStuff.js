const DateStuff = function (firstDateTime, secondDateTime) {
    this.firstDateTime = firstDateTime;
    this.secondDateTime = secondDateTime;
    this.now = new Date()
}

DateStuff.prototype.returnTestString = function (testString) {
    return (testString)
}

DateStuff.prototype.milliSecondsBetween = function () {
    return this.firstDateTime - this.secondDateTime
}

DateStuff.prototype.unitReturn = function (unit) {
    const milliseconds = this.firstDateTime - this.secondDateTime
    const seconds = Math.floor(milliseconds / 1000)
    const minutes = Math.floor(seconds / 60)
    const hours = Math.floor(minutes / 60)
    const days = Math.floor(hours / 24)
    const millisecondsRemainder = milliseconds - (seconds * 1000)
    const secondsRemainder = seconds - (minutes * 60)
    const minutesRemainder = minutes - (hours * 60)
    const hoursRemainder = hours - (days * 24)
    const formattedTime = {
        "days": days,
        "hours": hoursRemainder,
        "minutes": minutesRemainder,
        "seconds": secondsRemainder,
        "milliseconds": millisecondsRemainder
    }
    if (unit === "seconds") { return seconds }
    if (unit === "minutes") { return minutes }
    if (unit === "hours") { return hours }
    if (unit === "days") { return days }
    if (unit === "dict") { return formattedTime }
}



module.exports = DateStuff