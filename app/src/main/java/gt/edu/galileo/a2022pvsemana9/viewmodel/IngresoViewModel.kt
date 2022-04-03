package gt.edu.galileo.a2022pvsemana9.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import gt.edu.galileo.a2022pvsemana9.db.Hero
import gt.edu.galileo.a2022pvsemana9.db.HeroDatabase
import kotlinx.coroutines.launch

class IngresoViewModel(app: Application) : BaseViewModel(app) {
    fun insertHero(hero: Hero) {
        launch {
            HeroDatabase(getApplication()).heroDao().insertAll(hero)
        }
    }
}