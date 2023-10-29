package pe.edu.hiresync_mobileapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.hiresync_mobileapp.data.model.Postulation
import pe.edu.hiresync_mobileapp.repository.PostulationRepository
import pe.edu.hiresync_mobileapp.utils.Result

class PostulationViewModel(private val postulationRepository: PostulationRepository = PostulationRepository()): ViewModel() {
    private var _postulations = MutableLiveData<List<Postulation>>()
    val postulations get() = _postulations
    fun getAll() {
        postulationRepository.getAll { result ->
            if (result is Result.Success) {
                _postulations.value = result.data!!
            }
        }
    }

}

