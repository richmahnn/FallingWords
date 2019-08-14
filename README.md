# FallingWords

<br/>

##How was the time distributed (concept, model layer, view(s), game mechanics)

-> Concept design and dependencies 1:20 mins
<br/>
-> Data repo implementation and models 40mins
<br/>
-> Game logic and UI 6 hours

###Total time invested 8 hours

## Decisions made to solve certain aspects of the game
-> Mapped translation data into a collection(array)
-> Gave a user enough time to slelect a translation (7 seconds)
-> Reshuffle the translations on app launch

## Decisions made because of restricted time
-> MVVM would have been the perfect architecture for this project but it would have taken me much time
-> Simple game with no reset-game, pause, resume, difficulty adjustment because of time
-> Didn't implement threading and tests

## What would be the first thing to improve or add if there had been more time
-> Switch to MVVM architecture
-> Add tests both UI and Unit
-> Add game levels and complexity
-> Change animation to a more fun animation and also add sounds
-> Implement a better way for correct and wrong translations
