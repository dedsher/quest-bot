require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: 
    state: Start
        q!: $regex</start>
        a: Молви друг и войди!
        
        state: Melon
            q: * *melon~мелон* *
            a: Входите! Вы пошли в подземелье Мории! Перед вами три коридора.
                Ваши действия?
            
            state: Left
                q: * *лев* *
                a: Вас съел дракон
                
            state: Right
                q: * *прав* *
                a: Перед вами сундук. Ваши действия
                
                state: Open
                    q: открыть
                    a: В сундуке сказались монеты, ровно {{ getRandomInt(10) }}.
                    
                state: Straight
                q: * *прям* *
                a: Вы упали в яму
                
            state: Back
                q: * (назад|~вернуться|~вернуть|~возвращаться) *
                a: Вход завалило. Выберите другое направление.
                
            state: NoMatchWay
                event!: noMatch
                a: Выберите направление
        
    state: NoMatch
        event!: noMatch
        a: Попробуйте сказать это на эльфийском!