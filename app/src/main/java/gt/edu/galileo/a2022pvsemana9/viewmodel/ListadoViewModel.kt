package gt.edu.galileo.a2022pvsemana9.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gt.edu.galileo.a2022pvsemana9.db.Hero
import gt.edu.galileo.a2022pvsemana9.db.HeroDatabase
import kotlinx.coroutines.launch

class ListadoViewModel(app: Application): BaseViewModel(app){
    val heroList = MutableLiveData<List<Hero>>()

    fun loadHero() {
        launch {
            heroList.value = HeroDatabase(getApplication()).heroDao().getHeros()
        }
    }
}